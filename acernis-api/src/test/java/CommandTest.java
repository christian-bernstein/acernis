import de.christianbernstein.acernis.api.command.Node;
import de.christianbernstein.acernis.api.command.NodeDeclaration;
import de.christianbernstein.acernis.api.command.Visibility;
import de.christianbernstein.acernis.api.command.INode;

import java.util.Arrays;

/**
 * @author Christian Bernstein
 */
public class CommandTest {

    // Medium configured node
    @NodeDeclaration
    public static final INode echoNode = Node.builder()
            .literal("echo")
            .aliases(Arrays.asList("e", "print"))
            .description("Prints an echo to the output console. By default the system out stream.")
            .usage("echo [message]")
            .permission("echo.basic")
            .confirmationReliant(false)
            .visibility(Visibility.PUBLIC)
            .executor((conductor, parameters, properties, raw) -> System.out.println("" + parameters.get("message")))
            .build();

    // Minimum configured node
    @NodeDeclaration
    public static final INode helpNode = Node.builder()
            .literal("help")
            .executor((conductor, parameters, properties, raw) -> System.out.println("Cool help page"))
            .build();

    public static void main(String[] args) {

    }

}
