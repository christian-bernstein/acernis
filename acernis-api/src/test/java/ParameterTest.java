import de.christianbernstein.acernis.api.internal.command.parameters.IRuleset;
import de.christianbernstein.acernis.api.internal.command.parameters.Ruleset;
import de.christianbernstein.acernis.api.internal.command.parameters.StringParam;

/**
 * @author Christian Bernstein
 */
public class ParameterTest {

    public static void main(String[] args) {
        final IRuleset ruleset = Ruleset.builder()
                .parameter(StringParam.builder().build())
                .build();

        final String command = "acernis echo xXChrisXx Hello_world!";


    }

}
