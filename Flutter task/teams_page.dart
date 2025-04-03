import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class AddTeamsPage extends StatefulWidget {
  const AddTeamsPage({super.key});

  @override
  _AddTeamsPageState createState() => _AddTeamsPageState();
}

class _AddTeamsPageState extends State<AddTeamsPage> {
  final _team1Controller = TextEditingController();
  final _team2Controller = TextEditingController();
  final _score1Controller = TextEditingController();
  final _score2Controller = TextEditingController();
  final _odds1Controller = TextEditingController();
  final _odds2Controller = TextEditingController();

  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  @override
  void dispose() {
    _team1Controller.dispose();
    _team2Controller.dispose();
    _score1Controller.dispose();
    _score2Controller.dispose();
    _odds1Controller.dispose();
    _odds2Controller.dispose();
    super.dispose();
  }

  void _addMatch() {
    if (_team1Controller.text.isEmpty ||
        _team2Controller.text.isEmpty ||
        _score1Controller.text.isEmpty ||
        _score2Controller.text.isEmpty ||
        _odds1Controller.text.isEmpty ||
        _odds2Controller.text.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('All fields are required!')),
      );
      return;
    }

    try {
      int score1 = int.parse(_score1Controller.text);
      int score2 = int.parse(_score2Controller.text);
      double odds1 = double.parse(_odds1Controller.text);
      double odds2 = double.parse(_odds2Controller.text);

      _firestore.collection('football_matches').add({
        'team1': _team1Controller.text,
        'team2': _team2Controller.text,
        'score1': score1,
        'score2': score2,
        'odds1': odds1,
        'odds2': odds2,
        'timestamp': FieldValue.serverTimestamp(),
      });

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Match added successfully!')),
      );

      _team1Controller.clear();
      _team2Controller.clear();
      _score1Controller.clear();
      _score2Controller.clear();
      _odds1Controller.clear();
      _odds2Controller.clear();

      Navigator.pop(context);
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Invalid input format!')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add Football Match'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _team1Controller,
              decoration: InputDecoration(labelText: 'Team 1'),
            ),
            TextField(
              controller: _team2Controller,
              decoration: InputDecoration(labelText: 'Team 2'),
            ),
            TextField(
              controller: _score1Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Score 1'),
            ),
            TextField(
              controller: _score2Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Score 2'),
            ),
            TextField(
              controller: _odds1Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Odds for Team 1'),
            ),
            TextField(
              controller: _odds2Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Odds for Team 2'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: _addMatch,
              child: Text('Add Match'),
            ),
          ],
        ),
      ),
    );
  }
}

