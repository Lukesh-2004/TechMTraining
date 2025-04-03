import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class PlaceBetsPage extends StatelessWidget {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  PlaceBetsPage({super.key});

  // Method to place a bet on a match
  void _placeBet(BuildContext context, String matchId, String selectedTeam, double amount) {
    if (amount <= 0) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Please enter a valid amount')),
      );
      return;
    }

    _firestore.collection('user_bets').add({
      'match_id': matchId,
      'selected_team': selectedTeam,
      'amount': amount,
      'timestamp': FieldValue.serverTimestamp(),
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('Bet of \$${amount.toStringAsFixed(2)} placed on $selectedTeam')),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Place Bets'),
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: _firestore.collection('football_matches').snapshots(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return const Center(child: Text("No matches available"));
          }

          var matches = snapshot.data!.docs;
          return ListView.builder(
            itemCount: matches.length,
            itemBuilder: (context, index) {
              var match = matches[index];
              return ListTile(
                title: Text('${match['team1']} vs ${match['team2']}'),
                subtitle: Text('Odds: ${match['odds1']} - ${match['odds2']}'),
                onTap: () => _showBetDialog(context, match),
              );
            },
          );
        },
      ),
    );
  }

  void _showBetDialog(BuildContext context, QueryDocumentSnapshot match) {
    final TextEditingController _amountController = TextEditingController();

    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: const Text('Place Bet'),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              const Text('Enter your bet amount:'),
              const SizedBox(height: 10),
              TextField(
                controller: _amountController,
                keyboardType: const TextInputType.numberWithOptions(decimal: true),
                decoration: const InputDecoration(
                  labelText: 'Bet Amount',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  ElevatedButton(
                    onPressed: () {
                      double amount = double.tryParse(_amountController.text) ?? 0;
                      _placeBet(context, match.id, match['team1'], amount);
                      Navigator.pop(context);
                    },
                    child: Text('Bet on ${match['team1']}'),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      double amount = double.tryParse(_amountController.text) ?? 0;
                      _placeBet(context, match.id, match['team2'], amount);
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
}

