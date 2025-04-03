import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'bet_history_page.dart'; // Bet history page

class HomePage extends StatelessWidget {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Football Scores & Betting Odds'),
        actions: [
          IconButton(
            icon: const Icon(Icons.history),
            onPressed: () {
              // Navigate to the Bet History page
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => BetHistoryPage()),
              );
            },
            tooltip: 'View Bet History',
          ),
        ],
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: _firestore.collection('football_matches').snapshots(), // Fetch matches
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snapshot.hasError) {
            return const Center(child: Text("Error loading matches"));
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return const Center(child: Text("No matches available"));
          }

          var matches = snapshot.data!.docs;
          return ListView.builder(
            itemCount: matches.length,
            itemBuilder: (context, index) {
              var match = matches[index];
              return Card(
                margin: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                elevation: 3,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                child: ListTile(
                  title: Text('${match['team1']} vs ${match['team2']}',
                      style: const TextStyle(fontWeight: FontWeight.bold)),
                  subtitle: Text(
                      'Score: ${match['score1']} - ${match['score2']} \nOdds: ${match['odds1']} - ${match['odds2']}'),
                  onTap: () => _showBetOptions(context, match),
                  trailing: const Icon(Icons.sports_soccer, color: Colors.blue),
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            onPressed: () => Navigator.pushNamed(context, '/add_teams'),
            tooltip: 'Add Football Teams',
            child: const Icon(Icons.add),
          ),
          const SizedBox(width: 10),
          FloatingActionButton(
            onPressed: () => Navigator.pushNamed(context, '/place_bets'),
            tooltip: 'Place Bets',
            child: const Icon(Icons.sports_basketball),
          ),
        ],
      ),
    );
  }

  // Method to show bet options in a BottomSheet
  void _showBetOptions(BuildContext context, QueryDocumentSnapshot match) {
    TextEditingController betAmountController = TextEditingController();

    showModalBottomSheet(
      context: context,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      builder: (context) {
        return Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'Place Bet on ${match['team1']} or ${match['team2']}',
                style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
              ),
              const SizedBox(height: 10),
              TextField(
                controller: betAmountController,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(labelText: "Enter bet amount"),
              ),
              const SizedBox(height: 10),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  ElevatedButton(
                    onPressed: () {
                      _placeBet(context, match.id, match['team1'], betAmountController.text);
                      Navigator.pop(context);
                    },
                    child: Text('Bet on ${match['team1']}'),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      _placeBet(context, match.id, match['team2'], betAmountController.text);
                      Navigator.pop(context);
                    },
                    child: Text('Bet on ${match['team2']}'),
                  ),
                ],
              ),
            ],
          ),
        );
      },
    );
  }

  // Method to place a bet on a match with a custom amount
  void _placeBet(BuildContext context, String matchId, String selectedTeam, String amount) {
    double betAmount = double.tryParse(amount) ?? 0;
    if (betAmount <= 0) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Invalid bet amount. Please enter a valid number.')),
      );
      return;
    }

    FirebaseFirestore.instance.collection('user_bets').add({
      'match_id': matchId,
      'selected_team': selectedTeam,
      'amount': betAmount,
      'timestamp': FieldValue.serverTimestamp(),
    });

    // Show confirmation message
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('Bet placed on $selectedTeam for \$${betAmount.toStringAsFixed(2)}')),
    );
  }
}

