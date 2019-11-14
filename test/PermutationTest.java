import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTest {
    @Test
    public void test_permutation_null() {
        ArrayList<String> output = Permutation.permute(null);
        String[] expected = {};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_emptyString() {
        ArrayList<String> output = Permutation.permute("");
        String[] expected = {};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_allUppercase() {
        ArrayList<String> output = Permutation.permute("GOD");
        String[] expected = {"DGO","DOG","GDO","GOD","ODG","OGD"};
        Object[] outputAsArray = output.toArray();
        System.out.print(Arrays.toString(outputAsArray));
        Assert.assertArrayEquals(
                expected,
                outputAsArray
        );
    }

    @Test
    public void test_permutation_allUppercaseDuplicates() {
        ArrayList<String> output = Permutation.permute("DOGO");
        String[] expected = {"DGOO","DOGO","DOOG","GDOO","GODO","GOOD","ODGO","ODOG","OGDO","OGOD","OODG","OOGD"};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_mixCases() {
        ArrayList<String> output = Permutation.permute("DoGO");
        String[] expected = {"DGOo","DGoO","DOGo","DOoG","DoGO","DoOG","GDOo","GDoO","GODo","GOoD","GoDO","GoOD","ODGo",
                "ODoG","OGDo","OGoD","OoDG","OoGD","oDGO","oDOG","oGDO","oGOD","oODG","oOGD"};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_mixCasesDuplicates() {
        ArrayList<String> output = Permutation.permute("oDoOO");
        String[] expected = {"DOOoo","DOoOo","DOooO","DoOOo","DoOoO","DooOO","ODOoo","ODoOo","ODooO","OODoo","OOoDo",
                "OOooD","OoDOo","OoDoO","OoODo","OoOoD","OooDO","OooOD","oDOOo","oDOoO","oDoOO","oODOo","oODoO","oOODo",
                "oOOoD","oOoDO","oOoOD","ooDOO","ooODO","ooOOD"};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_mixedCasesWithNonLetters() {
        ArrayList<String> output = Permutation.permute("@oGd1");
        String[] expected = {"1@Gdo","1@God","1@dGo","1@doG","1@oGd","1@odG","1G@do","1G@od","1Gd@o","1Gdo@","1Go@d",
                "1God@","1d@Go","1d@oG","1dG@o","1dGo@","1do@G","1doG@","1o@Gd","1o@dG","1oG@d","1oGd@","1od@G","1odG@",
                "@1Gdo","@1God","@1dGo","@1doG","@1oGd","@1odG","@G1do","@G1od","@Gd1o","@Gdo1","@Go1d","@God1","@d1Go",
                "@d1oG","@dG1o","@dGo1","@do1G","@doG1","@o1Gd","@o1dG","@oG1d","@oGd1","@od1G","@odG1","G1@do","G1@od",
                "G1d@o","G1do@","G1o@d","G1od@","G@1do","G@1od","G@d1o","G@do1","G@o1d","G@od1","Gd1@o","Gd1o@","Gd@1o",
                "Gd@o1","Gdo1@","Gdo@1","Go1@d","Go1d@","Go@1d","Go@d1","God1@","God@1","d1@Go","d1@oG","d1G@o","d1Go@",
                "d1o@G","d1oG@","d@1Go","d@1oG","d@G1o","d@Go1","d@o1G","d@oG1","dG1@o","dG1o@","dG@1o","dG@o1","dGo1@",
                "dGo@1","do1@G","do1G@","do@1G","do@G1","doG1@","doG@1","o1@Gd","o1@dG","o1G@d","o1Gd@","o1d@G","o1dG@",
                "o@1Gd","o@1dG","o@G1d","o@Gd1","o@d1G","o@dG1","oG1@d","oG1d@","oG@1d","oG@d1","oGd1@","oGd@1","od1@G",
                "od1G@","od@1G","od@G1","odG1@","odG@1"};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

    @Test
    public void test_permutation_mixedCasesWithNonLettersDuplicates() {
        ArrayList<String> output = Permutation.permute("D@@g11");
        String[] expected = {"11@@Dg","11@@gD","11@D@g","11@Dg@","11@g@D","11@gD@","11D@@g","11D@g@","11Dg@@","11g@@D",
                "11g@D@","11gD@@","1@1@Dg","1@1@gD","1@1D@g","1@1Dg@","1@1g@D","1@1gD@","1@@1Dg","1@@1gD","1@@D1g",
                "1@@Dg1","1@@g1D","1@@gD1","1@D1@g","1@D1g@","1@D@1g","1@D@g1","1@Dg1@","1@Dg@1","1@g1@D","1@g1D@",
                "1@g@1D","1@g@D1","1@gD1@","1@gD@1","1D1@@g","1D1@g@","1D1g@@","1D@1@g","1D@1g@","1D@@1g","1D@@g1",
                "1D@g1@","1D@g@1","1Dg1@@","1Dg@1@","1Dg@@1","1g1@@D","1g1@D@","1g1D@@","1g@1@D","1g@1D@","1g@@1D",
                "1g@@D1","1g@D1@","1g@D@1","1gD1@@","1gD@1@","1gD@@1","@11@Dg","@11@gD","@11D@g","@11Dg@","@11g@D",
                "@11gD@","@1@1Dg","@1@1gD","@1@D1g","@1@Dg1","@1@g1D","@1@gD1","@1D1@g","@1D1g@","@1D@1g","@1D@g1",
                "@1Dg1@","@1Dg@1","@1g1@D","@1g1D@","@1g@1D","@1g@D1","@1gD1@","@1gD@1","@@11Dg","@@11gD","@@1D1g",
                "@@1Dg1","@@1g1D","@@1gD1","@@D11g","@@D1g1","@@Dg11","@@g11D","@@g1D1","@@gD11","@D11@g","@D11g@",
                "@D1@1g","@D1@g1","@D1g1@","@D1g@1","@D@11g","@D@1g1","@D@g11","@Dg11@","@Dg1@1","@Dg@11","@g11@D",
                "@g11D@","@g1@1D","@g1@D1","@g1D1@","@g1D@1","@g@11D","@g@1D1","@g@D11","@gD11@","@gD1@1","@gD@11",
                "D11@@g","D11@g@","D11g@@","D1@1@g","D1@1g@","D1@@1g","D1@@g1","D1@g1@","D1@g@1","D1g1@@","D1g@1@",
                "D1g@@1","D@11@g","D@11g@","D@1@1g","D@1@g1","D@1g1@","D@1g@1","D@@11g","D@@1g1","D@@g11","D@g11@",
                "D@g1@1","D@g@11","Dg11@@","Dg1@1@","Dg1@@1","Dg@11@","Dg@1@1","Dg@@11","g11@@D","g11@D@","g11D@@",
                "g1@1@D","g1@1D@","g1@@1D","g1@@D1","g1@D1@","g1@D@1","g1D1@@","g1D@1@","g1D@@1","g@11@D","g@11D@",
                "g@1@1D","g@1@D1","g@1D1@","g@1D@1","g@@11D","g@@1D1","g@@D11","g@D11@","g@D1@1","g@D@11","gD11@@",
                "gD1@1@","gD1@@1","gD@11@","gD@1@1","gD@@11"};
        Assert.assertArrayEquals(
                expected,
                output.toArray()
        );
    }

}