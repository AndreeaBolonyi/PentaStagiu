package com.p5.adoptions.examples;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.CatDTO;

public class OopExample
{
    public static void main(String[] args)
    {
        Animal animal = new Animal();
        Animal animal2 = new Animal("Hachi", "http://hachi.jpg",1);
        Animal animal3 = new Animal()
                .setName("Hachi")
                .setPhotoUrl("photo");


        //Polymorphism
        CatDTO cat = new CatDTO("Machi", "photo",2);
        Animal catAnimal = new CatDTO("Zoro", "photo",3);

        cat.speak();
        catAnimal.speak();
    }
}
