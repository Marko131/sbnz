import React, {useState} from 'react';
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
  const meals = () =>
    props.day.meals
      ? props.day.meals.map((m, index) => (
          <Meal
            key={index}
            meal={m}
            imageUrl={
              'https://www.thegraciouspantry.com/wp-content/uploads/2018/08/clean-eating-lunch-box-burritos-v-1-.jpg'
            }
          />
        ))
      : null;
  return (
    <SafeAreaView style={{marginTop: 20, flex: 1}}>
      <ScrollView horizontal={true}>{meals()}</ScrollView>
      <TouchableOpacity
        style={styles.addMealButton}
        onPress={() => setModalVisible(true)}>
        <Text style={{textAlign: 'center'}}>Add meal</Text>
      </TouchableOpacity>
      <Modal
        animationType="fade"
        transparent={true}
        visible={modalVisible}
        onRequestClose={() => {
          Alert.alert('Modal has been closed.');
        }}>
        <AddMealModal hideModal={setModalVisible} />
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
  },
});

export default MealsContainer;
