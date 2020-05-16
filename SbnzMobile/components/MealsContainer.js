import React from 'react';
import {View, Text, ScrollView, SafeAreaView, StyleSheet} from 'react-native';
import Meal from './Meal';
const MealsContainer = () => {
  return (
    <SafeAreaView style={{marginTop: 20}}>
      <ScrollView horizontal={true}>
        <Meal imageUrl="https://www.wellplated.com/wp-content/uploads/2018/05/Steel-Cut-Oats-Recipe-600x716.jpg" />
        <Meal imageUrl="https://images-gmi-pmc.edge-generalmills.com/75a7343a-1520-4e95-a13f-e61b5fc5b741.jpg" />
        <Meal imageUrl="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/weightlosssmoothies-tripleberrysmoothiedelish-1576165562.jpg" />
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  text: {
    color: 'white',
  },
});

export default MealsContainer;
