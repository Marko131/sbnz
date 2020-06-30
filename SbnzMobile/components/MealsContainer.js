import React, {useState, useEffect} from 'react';
import {
  View,
  Text,
  ScrollView,
  SafeAreaView,
  StyleSheet,
  TouchableOpacity,
  Modal,
  TouchableHighlight,
} from 'react-native';
import Meal from './Meal';
import AddMealModal from './AddMealModal';
const MealsContainer = props => {
  const [modalVisible, setModalVisible] = useState(false);
  const [meals, setMeals] = useState([]);

  useEffect(() => {
    showMeals();
  }, [props]);

  const showMeals = () => {
    if (!props.day.mealRecipes) return;
    let mealsComponent = props.day.mealRecipes.map((m, index) => (
      <Meal
        key={index}
        meal={m}
        imageUrl={
          'https://www.thegraciouspantry.com/wp-content/uploads/2018/08/clean-eating-lunch-box-burritos-v-1-.jpg'
        }
      />
    ));
    setMeals(mealsComponent);
  };

  const addToList = meal => {
    setMeals([
      ...meals,
      <Meal
        key={meals.length + 1}
        meal={meal}
        imageUrl={
          'https://www.thegraciouspantry.com/wp-content/uploads/2018/08/clean-eating-lunch-box-burritos-v-1-.jpg'
        }
      />,
    ]);
    props.refresh();
  };
  return (
    <SafeAreaView style={{marginTop: 20, flex: 1}}>
      <ScrollView>{meals}</ScrollView>

      <TouchableOpacity
        style={styles.addMealButton}
        onPress={() => setModalVisible(true)}>
        <Text style={styles.buttonText}>Add meal</Text>
      </TouchableOpacity>
      <Modal
        animationType="fade"
        transparent={true}
        visible={modalVisible}
        onRequestClose={() => {
          Alert.alert('Modal has been closed.');
        }}>
        <AddMealModal hideModal={setModalVisible} addMealToList={addToList} />
      </Modal>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  text: {
    color: 'white',
  },
  addMealButton: {
    backgroundColor: 'white',
    paddingVertical: 10,
  },
  buttonText: {
    textAlign: 'center',
    textTransform: 'uppercase',
  },
});

export default MealsContainer;
