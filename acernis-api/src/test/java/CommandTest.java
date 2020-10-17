import de.christianbernstein.acernis.api.command.Node;
import de.christianbernstein.acernis.api.command.NodeDeclaration;
import de.christianbernstein.acernis.api.command.Parameters;
import de.christianbernstein.acernis.api.command.Visibility;
import de.christianbernstein.acernis.api.command.INode;

import java.util.Arrays;

/**
 * @author Christian Bernstein
 */
public class CommandTest {

    @NodeDeclaration
    public static final INode echoNode = Node.builder()
            .literal("echo")
            .aliases(Arrays.asList("e", "print"))
            .description("Prints an echo to the output console. By default the system out stream.")
            .usage("echo [message]")
            .permission("echo.basic")
            .confirmationReliant(false)
            .visibility(Visibility.PUBLIC)
            .parameters(Parameters.builder().build())
            .executor((conductor, parameters, properties, raw) -> System.out.println("" + parameters.get("message")))
            .build();

    public static void main(String[] args) {

    }

}
