package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import serenitylabs.tutorials.vetclinic.features.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.questions.TheRegisteredGuests;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

//tell junit this test will be run with Serenity
@RunWith(SerenityRunner.class)
public class BookAPetIntoAHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel(){

        //Given
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("PetHotel");

        //When
        petra.attemptsTo(
            CheckIn.aPet(ginger).into(petHotel)
//          new CheckIn(ginger, petHotel)
        );

        //Then
       // assertThat(petHotel.getPets(),hasItem(ginger));
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), hasItem(ginger)));


    }

}
