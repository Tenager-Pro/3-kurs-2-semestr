import React, {useEffect, useState} from 'react';
import {ActivityIndicator, FlatList, Text, View} from 'react-native';
import { TextInput } from 'react-native-web';

const App = () => {
  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);
  const [count, setCount] = useState([40]);
  const [number, setNumber] = useState([1]);
  const [isLoadingType, setLoadingType] = useState(true);
  const [dataType, setDataType] = useState([]);

  const getMovies = async () => {
    try {
      const response = await fetch('https://pokeapi.co/api/v2/pokemon?offset='+count+'&limit='+count);
      const json = await response.json();
      setData(json.results);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  const getPoke = async () => {
    try {
      const response = await fetch('https://pokeapi.co/api/v2/type/'+number);
      const json = await response.json();
      setDataType(json.pokemon);
    } catch (error) {
      console.error(error);
    } finally {
      setLoadingType(false);
    }
  };
  
  return (
    <> 
      <View>
        
        <button onClick={getMovies()}>Вывод</button>
        <TextInput onChangeText={setCount}/>
        {isLoading ? 
        (<ActivityIndicator/>) : (
          <FlatList
            data={data}
            keyExtractor={({id}) => id}
            renderItem={({item}) => (
              <Text>
                {item.name}
              </Text>
            )}
          />

        
        )}
         
        <button onClick={getPoke()}>Тип</button>
        <TextInput onChangeText={setNumber}/>
        {isLoadingType ? 
        (<ActivityIndicator/>) : (
          <FlatList
            data={dataType}
            keyExtractor={({id}) => id}
            renderItem={({item}) => (
              <Text>
                {item.pokemon.name}
              </Text>
            )}
          />
        )}
      </View>
    </>
  );
};

export default App;