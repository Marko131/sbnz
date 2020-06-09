import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import ProgressCircle from 'react-native-progress-circle';
const CalorieCounter = props => {
  const [calories, setCalories] = useState(0);
  useEffect(() => {
    let cal = props.profile.calories;
    props.day.meals
      ? props.day.meals.forEach(meal => {
          meal.ingredients.forEach(ingredient => {
            cal -= (ingredient.food.calories / 100) * ingredient.gram;
          });
        })
      : null;
    setCalories(parseInt(cal));
  });
  return (
    <>
      <View style={styles.counterContainer}>
        <ProgressCircle
          percent={64}
          radius={90}
          borderWidth={11}
          color="rgba(0, 255, 152, 1)"
          shadowColor="rgba(0, 106, 63, .6)"
          bgColor="#353535">
          <Text style={styles.counterText}>{calories}</Text>
          <Text style={{color: 'rgba(0, 255, 152, 1)', fontSize: 19}}>
            calories left
          </Text>
        </ProgressCircle>
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  counterText: {
    fontSize: 60,
    color: 'rgba(0, 255, 130, 1)',
    fontWeight: 'bold',
    textShadowColor: 'rgba(76, 255, 1, 0.7)',
    textShadowOffset: {width: 0, height: 0},
    textShadowRadius: 10,
  },
  counterContainer: {
    display: 'flex',
    justifyContent: 'center',
    flexDirection: 'row',
    marginTop: 30,
  },
});

export default CalorieCounter;
