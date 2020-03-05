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
        Neighbour neighbourToCreate = service.getNeighbours().get(0);
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
        neighbourToDeleteFavorite.setFavorite(true);
        service.deleteFavoriteNeighbour(neighbourToDeleteFavorite);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToDeleteFavorite));
    }

    @Test
    public void getNeighbourWithSuccess() {
        Neighbour neighbourToGet = service.getNeighbours().get(0);
        Neighbour neighbourToGet2 = service.getNeighbour(0);
        assertEquals(neighbourToGet, neighbourToGet2);
    }

}
