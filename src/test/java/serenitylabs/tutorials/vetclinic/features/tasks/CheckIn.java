package serenitylabs.tutorials.vetclinic.features.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        petHotel.checkIn(pet);
    }
}
