import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import MacroProgress from './MacroProgress';
import Axios from 'axios';

const width = 100;

const MacroContainer = props => {
  console.log(props);
  const calculateMacro = (day, profile) => {
    let fatTotal = profile.calories / 4 / 9;
    let carbTotal = profile.calories / 3 / 9;
    let proteinTotal = profile.calories / 3 / 9;

    let fat = profile.calories / 4 / 9;
    let carb = profile.calories / 3 / 9;
    let protein = profile.calories / 3 / 9;

    day.meals
      ? day.meals.forEach(meal => {
          meal.ingredients.forEach(ingredient => {
            fat -= (ingredient.food.fat / 100) * ingredient.gram;
            carb -= (ingredient.food.carb / 100) * ingredient.gram;
            protein -= (ingredient.food.protein / 100) * ingredient.gram;
          });
        })
      : null;
    const obj = {
      protein: parseInt(protein),
      fat: parseInt(fat),
      carb: parseInt(carb),
      proteinProgress: (proteinTotal - protein) / proteinTotal,
      fatProgress: (fatTotal - fat) / fatTotal,
      carbProgress: (carbTotal - carb) / carbTotal,
    };
    console.log(obj);
    return obj;
  };
  return (
    <View style={styles.container}>
      <MacroProgress
        macro="CARBS"
        progress={
          props.day.meals
            ? calculateMacro(props.day, props.profile).carbProgress
            : 0
        }
        grams={calculateMacro(props.day, props.profile).carb}
        marginTop={-30}
      />
      <MacroProgress
        macro="PROTEIN"
        progress={
          props.day.meals
            ? calculateMacro(props.day, props.profile).proteinProgress
            : 0
        }
        grams={calculateMacro(props.day, props.profile).protein}
      />
      <MacroProgress
        macro="FAT"
        progress={
          props.day.meals
            ? calculateMacro(props.day, props.profile).fatProgress
            : 0
        }
        grams={calculateMacro(props.day, props.profile).fat}
        marginTop={-30}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 30,
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'center',
  },
});

export default MacroContainer;
