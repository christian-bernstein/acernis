import com.google.gson.GsonBuilder;
import de.christianbernstein.acernis.api.command.INode;
import de.christianbernstein.acernis.api.command.Node;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class CommandTest2 {

    public static final Set<RegisteredNode> nodeTrees = new HashSet<>();

    public static final INode utilNode = Node.builder()
            .literal("util")
            .aliases(Arrays.asList("u", "helpers"))
            .build();

    public static final INode echoNode = Node.builder()
            .literal("echo")
            .aliases(Arrays.asList("e", "print"))
            .executor((conductor, parameters, properties, raw) -> System.out.println("" + parameters.get("message")))
            .build();

    public static void main(String[] args) {
        nodeTrees.add(RegisteredNode.builder()
                .node(utilNode)
                .child(RegisteredNode.builder()
                        .node(echoNode).build())
                .build());

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(nodeTrees));

        System.out.println("found node = " + getNode(nodeTrees, Arrays.asList("util", "echo")).get());
    }

    public static Optional<INode> getNode(Set<RegisteredNode> nodes, List<String> nodeRequest){
        final Optional<RegisteredNode> root = nodes.stream().filter(node -> node.test(nodeRequest.get(0))).findFirst();
        if (!root.isPresent()) return Optional.empty();

        final AtomicReference<RegisteredNode> current = new AtomicReference<>(root.get());
        final Iterator<String> iterator = nodeRequest.subList(1, nodeRequest.size()).stream().iterator();
        while (iterator.hasNext()){
            final String s = iterator.next();
            current.get().childNodes.forEach();


        }
    }

    public static Optional<INode> getNodeRecursively(RegisteredNode parent, String ){

    }

    @Builder
    public static class RegisteredNode implements Predicate<String> {

        @NonNull
        private final INode node;

        @Singular(value = "child")
        private final Set<RegisteredNode> childNodes;

        @Override
        public boolean test(String s) {
            return this.node.getLiteral().equals(s) || this.node.getAliases().contains(s);
        }
    }
}
