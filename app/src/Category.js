import React, { Component } from 'react';
import AppNav from './AppNav';
import {Button} from 'reactstrap';
//standard structure of a react component
class Category extends Component {
    //state is the internal storage of any component
    //like using private in java
    state = { 
        isLoading : true,
        //[] means it's an array of categories
        Categories : []
     }
        //after everything is mounted and everything is done make this async call to a springboot endpoint
        //const means the indentifier cannot be reassigned
     async componentDidMount(){
         const response=await fetch('/api/categories');
         const body = await response.json();
         this.setState({Categories :body , isLoading: false});
     }


    //in charge of processing the jsx file
    render() { 
        const {Categories , isLoading} = this.state;
        if(isLoading)
            return (<div>Loading...</div>);

        return ( 
            
            <div>
                <AppNav/>
                <h2>Expense Categories</h2>

                
                {
                    //puts our result within the curly braces
                    //map gets the categories from the state that we just got from our spring endpoint
                    //and create something called category, and map for every single category inside the categories map
                    Categories.map( category =>
                        <div id={category.id}>
                            {category.name}
                            </div>
                    //category.name is part of our response in localhost:8080
                    )

                }
                <br></br>
                   <Button href="/expenses"variant="secondary" size="lg" block>
    Click Here to Add an Expense!
  </Button>
            </div>
         );
    }
}
 
//returns them as an export to the other functions
export default Category;