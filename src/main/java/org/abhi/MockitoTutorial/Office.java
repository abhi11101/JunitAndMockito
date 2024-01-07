package org.abhi.MockitoTutorial;

import java.util.List;

public interface Office {

    List<String> characterList();

    void deleteNonOfficeChar(String str);
}
