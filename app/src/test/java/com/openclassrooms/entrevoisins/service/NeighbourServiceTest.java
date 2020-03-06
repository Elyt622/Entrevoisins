package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createNeighbourWithSuccess() {
        Neighbour neighbourToCreate =  new Neighbour(13, "Joseph", "https://i.pravatar.cc/300?u=a042581f3e39026702d", "Saint-Pierre-du-Mont ; 5km",
                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..");
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(3);
        neighbour.setFavorite(true);
        for(Neighbour i: service.getNeighbours()){
            if(i.getFavorite()){
                assertTrue(service.getFavoriteNeighbours().contains(i));
            }else {
                assertFalse(service.getFavoriteNeighbours().contains(i));
            }
        }
    }

    @Test
    public void addFavoriteNeighbourWithSuccess() {
        Neighbour neighbourToAddFavorite = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbourToAddFavorite);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddFavorite));
    }

    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        Neighbour neighbourToDeleteFavorite = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbourToDeleteFavorite);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToDeleteFavorite));
        service.deleteFavoriteNeighbour(neighbourToDeleteFavorite);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToDeleteFavorite));
    }

    @Test
    public void getNeighbourWithSuccess() {
        Neighbour neighbourToGet = service.getNeighbours().get(5);
        Neighbour neighbourToGet2 = service.getNeighbour(neighbourToGet.getId());
        assertEquals(neighbourToGet, neighbourToGet2);
    }

}