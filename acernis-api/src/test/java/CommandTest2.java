import com.google.gson.GsonBuilder;
import de.christianbernstein.acernis.command.node.INode;
import de.christianbernstein.acernis.command.node.Node;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class CommandTest2 {

    public static final Set<RegisteredNode> nodeTrees = new HashSet<>();

    public static final INode utilNode = Node.builder()
            .literal("util")
            .build();

    public static final INode echoNode = Node.builder()
            .literal("echo")
            .executor((context) -> System.out.println("" + context.getParameters().get("message")))
            .build();

    public static final INode exitNode = Node.builder()
            .literal("exit")
            .executor((context) -> System.out.println("" + context.getParameters().get("return")))
            .build();

    public static final INode infoNode = Node.builder()
            .literal("info")
            .build();

    public static final INode timeNode = Node.builder()
            .literal("time")
            .build();

    public static void main(String[] args) {
        nodeTrees.add(RegisteredNode.builder()
                .node(utilNode)
                .child(RegisteredNode.builder().node(echoNode).build())
                .child(RegisteredNode.builder().node(exitNode).build())
                .child(RegisteredNode.builder().node(infoNode)
                        .child(RegisteredNode.builder().node(timeNode).build()).build())
                .build());

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(nodeTrees));

        try {
            System.out.println("found node = " + getNode(nodeTrees, Arrays.asList("util", "info", "time")).get());
        }catch (final NoSuchElementException e){
            System.err.println("An error raised: " + e.getLocalizedMessage());
        }
    }

    public static Optional<INode> getNode(Set<RegisteredNode> nodes, List<String> nodeRequest){
        final Optional<RegisteredNode> root = nodes.stream().filter(node -> node.test(nodeRequest.get(0))).findFirst();
        if (!root.isPresent()) return Optional.empty();
        System.out.println("root node found = " + root.get().getNode().getLiteral());
        final AtomicReference<RegisteredNode> currentNode = new AtomicReference<>(root.get());
        for (int i = 1; i < nodeRequest.size(); i++) {
            final String currentRequest = nodeRequest.get(i);
            System.out.println("processing = " + currentRequest + ", at node = " + currentNode.get().getNode().getLiteral());
            // Process all child nodes
            currentNode.get().childNodes.forEach(child -> {
                if (child.test(currentRequest)){
                    System.out.println("Found a matching child node, set it as the new parent = " + child.getNode().getLiteral());
                    currentNode.set(child);
                }
            });
            // Validate the new parent node
            if (!currentNode.get().test(currentRequest)){
                System.err.println("Algorithm hit dead end, probably caused by a missing node (The command should be checked)");
                return Optional.empty();
            }
        }
        return Optional.of(currentNode.get().getNode());
    }

    @Builder
    @Data
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
