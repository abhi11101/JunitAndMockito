package org.abhi.MockitoTutorial;

import java.util.Arrays;
import java.util.List;

public class OfficeImpl implements Office{
    @Override
    public List<String> characterList() {
        return Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
    }

    @Override
    public void deleteNonOfficeChar(String str) {

    }
}
