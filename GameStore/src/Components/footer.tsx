import { SimpleGrid, Box, Text, HStack, Icon, Stack } from "@chakra-ui/react";
import React from "react";
import { FaFacebook, FaTwitter, FaInstagram } from "react-icons/fa";

const Footer = () => {
  return (
    <SimpleGrid
      justifyItems="center"
      w="100%"
      minChildWidth="260px"
      p={6}
      gap={6}
      minHeight="105.5px"
      bg="gray.700"
      color="white"
    >
      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">
          Gamers Hub
        </Text>
        <Text>© 2025 Gaming Website. All rights reserved.</Text>
      </Box>

      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">Links</Text>
        <Stack direction="row" spacing={4} justify="center">
          <Text>Home</Text>
          <Text>About</Text>
          <Text>Contact</Text>
        </Stack>
      </Box>

      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">Follow Us</Text>
        <HStack spacing={4} justify="center">
          <Icon as={FaFacebook} w={6} h={6} />
          <Icon as={FaTwitter} w={6} h={6} />
          <Icon as={FaInstagram} w={6} h={6} />
        </HStack>
      </Box>
    </SimpleGrid>
  );
};

export default Footer;
