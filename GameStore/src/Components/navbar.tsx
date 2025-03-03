import { HStack, Text, Image, SimpleGrid } from '@chakra-ui/react';
import logo from '../assets/logo.png';
import DarkSwitch from './darkswitch';
import SlideBar from './slidebar';
import React from 'react';

const navBar = () => {
  return (
    <HStack justifyContent={'space-between'} px={8} py={4}>
      <SimpleGrid
        display={'flex'}
        alignItems={'center'}
        gridTemplateColumns={'auto auto'}
        gap={4}
      >
        <Image src={logo} alt="logo" boxSize={'80px'} />
        <a href="/">
          <Text
            fontSize={'22px'}
            fontWeight={'bold'}
            _hover={{ color: 'teal.300', transform: 'scale(1.05)' }}
            transition="all 0.2s"
          >
            Gamers Hub
          </Text>
        </a>
      </SimpleGrid>

      <SimpleGrid
        display={'flex'}
        alignItems={'center'}
        gridTemplateColumns={'auto auto'}
        gap={6}
      >
        <DarkSwitch />
        <SlideBar />
      </SimpleGrid>
    </HStack>
  );
};

export default navBar;
