package com.p5.adoptions.examples;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.CatDTO;

public class OopExample
{
    public static void main(String[] args)
    {
        AnimalDTO animal = new AnimalDTO();
        AnimalDTO animal2 = new AnimalDTO("Hachi", "http://hachi.jpg",1);
        AnimalDTO animal3 = new AnimalDTO()
                .setName("Hachi")
                .setPhotoUrl("photo");


        //Polymorphism
        CatDTO cat = new CatDTO("Machi", "photo",2);
        AnimalDTO catAnimal = new CatDTO("Zoro", "photo",3);

        cat.speak();
        catAnimal.speak();
    }
}
