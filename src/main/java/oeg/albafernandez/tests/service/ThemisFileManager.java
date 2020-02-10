package oeg.albafernandez.tests.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;
import java.util.ArrayList;

public class ThemisFileManager {

    public String loadTests(String testUri) throws OWLOntologyStorageException, IOException, OWLOntologyCreationException, JSONException {
        ArrayList<String> testsuiteDesign = new ArrayList<>();
        ThemisImplementer impl = new ThemisImplementer();
        testsuiteDesign.addAll(impl.loadTestCaseDesign(testUri));
        JSONArray tests = new JSONArray();
        for (String test : testsuiteDesign) {
            JSONObject obj = new JSONObject();
            obj.put("Test", test);
            tests.put(obj);
        }

        return tests.toString();

    }

}
