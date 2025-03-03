import { Routes, Route, BrowserRouter } from 'react-router-dom';
import GameDetails from './Components/gamedetails';
import React from 'react';
import { Grid, GridItem } from '@chakra-ui/react'; // Ensure you import Grid components
import GameCard from './Components/gamecard';
import Footer from './Components/footer';

function App() {
  return (
    <BrowserRouter>
      <Grid templateAreas={`"nav nav" "aside main"`} h="100vh">
        <GridItem area={'nav'} bg="teal">
          <nav>
            {/* Add your Navbar Component here */}
          </nav>
        </GridItem>

        <GridItem area={'main'}>
          <Routes>
            <Route path="/" element={<GameCard />} />
            <Route path="details/:resId" element={<GameDetails />} />
          </Routes>
        </GridItem>

        <Footer />
      </Grid>
    </BrowserRouter>
  );
}

export default App;