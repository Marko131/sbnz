import React from 'react';
import {TextInput, View} from 'react-native';

const IngredientInput = () => {
  return (
    <View>
      <TextInput placeholder="Name" />
      <TextInput placeholder="Calories per 100g" />
    </View>
  );
};

export default IngredientInput;
