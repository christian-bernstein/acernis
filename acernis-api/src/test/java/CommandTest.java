import de.christianbernstein.acernis.api.command.INode;
import de.christianbernstein.acernis.api.command.Node;
import de.christianbernstein.acernis.api.command.NodeDeclaration;

/**
 * @author Christian Bernstein
 */
public class CommandTest {

    // Parameter-optimistic node
    @NodeDeclaration
    public static final INode echoNode = Node.builder()
        .literal("echo")
        .executor(context -> System.out.println("" + context.getParameters().get("message")))
        .build();

    public static void main(String[] args) {

    }

}
