package com.openclassrooms.entrevoisins.service;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public Neighbour getNeighbour(long id) {
        Neighbour neighbour = null;
        for(Neighbour i : neighbours) {
            if(i.getId() == id){
                neighbour = i;
                break;
            }
        }
        return neighbour;
    }

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        ArrayList<Neighbour> favoriteNeighbours = new ArrayList<>();
        for (Neighbour i : neighbours) {
            if (i.getFavorite()) {
                favoriteNeighbours.add(i);
            }
        }
        return favoriteNeighbours;
    }

    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        neighbour.setFavorite(true);
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        neighbour.setFavorite(false);
    }

}
