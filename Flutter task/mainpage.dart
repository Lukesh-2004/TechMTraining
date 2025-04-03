import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'teams_page.dart';  // Page for adding football teams
import 'place_bets_page.dart'; // Page for placing bets
import 'homepage.dart';       // Home page for listing teams, scores, and odds

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: Firebase.initializeApp(),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const MaterialApp(
            home: Scaffold(
              body: Center(child: CircularProgressIndicator()),
            ),
          );
        } else if (snapshot.hasError) {
          return MaterialApp(
            home: Scaffold(
              body: Center(
                child: Text(
                  'Failed to initialize Firebase. Please restart the app.',
                  style: TextStyle(color: Colors.red, fontSize: 16),
                ),
              ),
            ),
          );
        }

        return MaterialApp(
          title: 'Football Scores & Betting Odds',
          debugShowCheckedModeBanner: false,  // Hides debug banner
          initialRoute: '/',
          routes: {
            '/': (context) => HomePage(),        // Home Page
            '/add_teams': (context) => AddTeamsPage(),  // Add Teams Page
            '/place_bets': (context) => PlaceBetsPage(), // Place Bets Page
          },
        );
      },
    );
  }
}

