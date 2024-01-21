package com.cz.demo.utils;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.MockitoAnnotations.openMocks;

public class BaseUnitTestClass {

    @BeforeEach
    void init_mocks() {
        openMocks(this);
    }

}
