import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import ProgressCircle from 'react-native-progress-circle';
const CalorieCounter = props => {
  const [calories, setCalories] = useState(0);
  const [totalCalories, setTotalCalories] = useState(0);
  useEffect(() => {
    let cal = props.profile.calories;

    props.day.mealRecipes
      ? props.day.mealRecipes.forEach(meal => {
          cal -= meal.calories;
        })
      : null;

    props.day.user ? setTotalCalories(props.day.user.calories) : null;
    setCalories(parseInt(cal));
    console.log('Cal', calories);
    console.log('Total', totalCalories);
  }, [props]);
  return (
    <>
      <View style={styles.counterContainer}>
        <ProgressCircle
          percent={((totalCalories - calories) / totalCalories) * 100}
          radius={90}
          borderWidth={11}
          color={calories >= 0 ? 'rgba(0, 255, 152, 1)' : '#d50000'}
          bgColor="#353535">
          <Text
            style={
              calories >= 0 ? styles.counterTextLeft : styles.counterTextOver
            }>
            {calories >= 0 ? parseInt(calories) : parseInt(0 - calories)}
          </Text>
          <Text
            style={{
              color: calories >= 0 ? 'rgba(0, 255, 152, 1)' : 'red',
              fontSize: 19,
            }}>
            calories {calories >= 0 ? 'left' : 'over'}
          </Text>
        </ProgressCircle>
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  counterTextLeft: {
    fontSize: 60,
    color: 'rgba(0, 255, 130, 1)',
    fontWeight: 'bold',
    textShadowColor: 'rgba(76, 255, 1, 0.7)',
    textShadowOffset: {width: 0, height: 0},
    textShadowRadius: 10,
  },
  counterTextOver: {
    fontSize: 60,
    color: '#d50000',
    fontWeight: 'bold',
    textShadowColor: 'rgba(255, 0, 0, 0.7)',
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
