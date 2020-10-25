import de.christianbernstein.acernis.api.internal.command.node.INode;
import de.christianbernstein.acernis.api.internal.command.node.Node;
import de.christianbernstein.acernis.api.internal.command.node.NodeDeclaration;

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
