import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import MacroProgress from './MacroProgress';

const width = 100;

const MacroContainer = props => {
  const [protein, setProtein] = useState(0);
  const [fat, setFat] = useState(0);
  const [carbs, setCarbs] = useState(0);
  const [proteinProgress, setProteinProgress] = useState(0);
  const [fatProgress, setFatProgress] = useState(0);
  const [carbsProgress, setCarbsProgress] = useState(0);

  useEffect(() => {
    if (props.day.user) {
      let fIntake = 0;
      let f = parseInt(props.day.user.calories / 4 / 9);
      let cIntake = 0;
      let c = parseInt(props.day.user.calories / 2 / 4);
      let pIntake = 0;
      let p = parseInt(props.day.user.calories / 4 / 4);

      props.day.mealRecipes.forEach(m => (fIntake += m.fat));
      props.day.mealRecipes.forEach(m => (pIntake += m.protein));
      props.day.mealRecipes.forEach(m => (cIntake += m.carbohydrates));

      setProtein(p - parseInt(pIntake));
      setCarbs(c - parseInt(cIntake));
      setFat(f - parseInt(fIntake));

      setCarbsProgress(cIntake / c);
      setProteinProgress(pIntake / p);
      setFatProgress(fIntake / f);
    }
  }, [props]);
  return (
    <View style={styles.container}>
      <MacroProgress
        macro="CARBS"
        progress={carbsProgress}
        grams={carbs}
        marginTop={-30}
      />
      <MacroProgress
        macro="PROTEIN"
        progress={proteinProgress}
        grams={protein}
      />
      <MacroProgress
        macro="FAT"
        progress={fatProgress}
        grams={fat}
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
