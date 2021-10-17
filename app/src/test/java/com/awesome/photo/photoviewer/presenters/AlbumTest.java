package com.awesome.photo.photoviewer.presenters;

import com.awesome.photo.remote.api.models.AlbumsModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AlbumTest {
    Album classUnderTest;

    List<AlbumsModel> albumsList;
    int baseId = 1;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        albumsList = new ArrayList<>();
        classUnderTest = new Album(baseId, albumsList);
    }

    @Test
    public void getPhotos() {
        assertEquals(albumsList, classUnderTest.getPhotos());
    }

    @Test
    public void setPhotos() {
        List<AlbumsModel> expected = new ArrayList<>();
        classUnderTest.setPhotos(expected);
        assertEquals(expected, classUnderTest.getPhotos());
    }

    @Test
    public void getId() {
        assertEquals(baseId, classUnderTest.getId());
    }

    @Test
    public void setId() {
        int expected = 2;
        classUnderTest.setId(2);

        assertEquals(expected, classUnderTest.getId());
    }
}