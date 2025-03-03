import { HStack, Switch, useColorMode } from '@chakra-ui/react';
import React from 'react';

function DarkSwitch() {
const { colorMode, toggleColorMode } = useColorMode(); 

return (
    <HStack spacing={4} p={4} justify="center">
    <Switch
        isChecked={colorMode === 'dark'}
        onChange={toggleColorMode}
        colorScheme="teal"
        size="lg"
        boxShadow="0 0 5px rgba(0, 0, 0, 0.2)"
    />
    </HStack>
);
}

export default DarkSwitch;
