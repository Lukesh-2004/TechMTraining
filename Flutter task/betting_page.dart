import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart'; // For date formatting

class BetHistoryPage extends StatelessWidget {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  BetHistoryPage({super.key});

  String _formatTimestamp(Timestamp? timestamp) {
    if (timestamp == null) return "Unknown date";
    return DateFormat.yMMMd().add_jm().format(timestamp.toDate());
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Bet History'),
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: _firestore.collection('user_bets').orderBy('timestamp', descending: true).snapshots(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snapshot.hasError) {
            return const Center(child: Text("Error loading bet history"));
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return const Center(child: Text("No bets placed yet"));
          }

          var bets = snapshot.data!.docs;
          return ListView.builder(
            itemCount: bets.length,
            itemBuilder: (context, index) {
              var bet = bets[index];

              String selectedTeam = bet['selected_team'] ?? 'Unknown';
              double amount = (bet['amount'] as num).toDouble();
              String matchId = bet['match_id'] ?? 'N/A';
              String timestamp = _formatTimestamp(bet['timestamp']);

              return Card(
                margin: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                elevation: 3,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                child: ListTile(
                  title: Text('Bet on: $selectedTeam', style: TextStyle(fontWeight: FontWeight.bold)),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Amount: \$${amount.toStringAsFixed(2)}'),
                      Text('Match ID: $matchId'),
                      Text('Placed on: $timestamp', style: TextStyle(fontSize: 12, color: Colors.grey)),
                    ],
                  ),
                  leading: Icon(Icons.sports_soccer, color: Colors.blue),
                ),
              );
            },
          );
        },
      ),
    );
  }
}

