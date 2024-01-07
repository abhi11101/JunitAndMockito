package org.abhi.MockitoTutorial;

import java.util.ArrayList;
import java.util.List;

public class OfficeCharacterCheck {

    private Office office;

    public OfficeCharacterCheck(Office office) {
        this.office = office;
    }

    public List<String> filterCharacter(){
        List<String> filterCharacters = new ArrayList<>();
        List<String> CharacterList = office.characterList();
        for (String str : CharacterList){
            if (str.contains("Office")){
                filterCharacters.add(str);
            }
        }
        return filterCharacters;
    }

    public void deleteCharNonOffice(){
        List<String> officeChars = office.characterList();

        for (String str : officeChars){
            if (!str.contains("Office")){
                office.deleteNonOfficeChar(str);
            }
        }
    }
}
