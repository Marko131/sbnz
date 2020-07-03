import React, {useState} from 'react';
import {
  View,
  Text,
  TouchableHighlight,
  StyleSheet,
  TextInput,
  TouchableWithoutFeedback,
  TouchableOpacity,
} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';
import Axios from 'axios';
import IngredientInput from './IngredientInput';
import AsyncStorage from '@react-native-community/async-storage';
import {ScrollView} from 'react-native-gesture-handler';

const AddMealModal = props => {
  const [searchValue, setSearchValue] = useState('');
  const [meals, setMeals] = useState([]);

  const searchMeals = async () => {
    if (searchValue == '') return;
    const value = await AsyncStorage.getItem('access_token');
    if (value !== null) {
      Axios.get(`http://10.0.2.2:8080/day/meal/search/${searchValue}`, {
        headers: {'X-Auth-Token': value},
      })
        .then(response => setMeals(response.data))
        .catch(error => alert(error));
    }
  };

  const submitMeal = async id => {
    const value = await AsyncStorage.getItem('access_token');
    if (value !== null) {
      Axios.post(
        `http://10.0.2.2:8080/day/meal/${id}`,
        {},
        {
          headers: {'X-Auth-Token': value},
        },
      )
        .then(response => props.addMealToList(response.data))
        .catch(error => alert(error));
    }
  };

  return (
    <TouchableWithoutFeedback onPress={() => props.hideModal(false)}>
      <View style={styles.centeredView}>
        <TouchableWithoutFeedback>
          <View style={styles.modalView}>
            <Text style={styles.modalText}>Add meal!</Text>

            <View
              style={{
                display: 'flex',
                flexDirection: 'row',
                alignItems: 'center',
              }}>
              <TextInput
                placeholder="Search meals..."
                value={searchValue}
                onChangeText={value => setSearchValue(value)}
                style={styles.input}
              />
              <TouchableOpacity onPress={searchMeals}>
                <Icon name="search" size={25} color="#353535" />
              </TouchableOpacity>
            </View>

            <TouchableHighlight
              style={{
                ...styles.openButton,
                backgroundColor: '#2196F3',
                marginTop: 30,
              }}
              onPress={() => props.hideModal(false)}>
              <Text style={styles.textStyle}>Close</Text>
            </TouchableHighlight>

            <ScrollView>
              {meals.map((meal, index) => (
                <View key={index} style={styles.searchItem}>
                  <Text>{meal.name}</Text>
                  <TouchableOpacity onPress={() => submitMeal(meal.id)}>
                    <Icon name="add" size={25} color="#353535" />
                  </TouchableOpacity>
                </View>
              ))}
            </ScrollView>
          </View>
        </TouchableWithoutFeedback>
      </View>
    </TouchableWithoutFeedback>
  );
};

const styles = StyleSheet.create({
  centeredView: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 22,
    backgroundColor: 'rgba(0, 0, 0, .4)',
  },
  modalView: {
    margin: 20,
    backgroundColor: 'white',
    borderRadius: 20,
    padding: 35,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
    width: '80%',
  },
  openButton: {
    backgroundColor: '#F194FF',
    borderRadius: 20,
    padding: 10,
    elevation: 2,
  },
  textStyle: {
    color: 'white',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  modalText: {
    marginBottom: 15,
    textAlign: 'center',
  },
  input: {
    width: '100%',
    backgroundColor: '#fafafa',
    borderRadius: 50,
    padding: 10,
  },
  searchItem: {
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginVertical: 5,
  },
});

export default AddMealModal;
