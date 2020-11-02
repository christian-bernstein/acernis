import de.christianbernstein.acernis.CommandFramework;
import de.christianbernstein.acernis.node.INode;
import de.christianbernstein.acernis.node.ReflectionObjectHolderNodeSource;

/**
 * @author Christian Bernstein
 */
public class ApiTest {

    private static final CommandFramework framework = CommandFramework.builder().build();

    public static void main(String[] args) {
        ReflectionObjectHolderNodeSource.builder().targetNodeClass(INode.class).pack("de.christianbernstein.acernis.samples").build().get();
    }

}
