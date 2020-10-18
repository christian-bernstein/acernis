package de.christianbernstein.acernis.api.command;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Christian Bernstein
 */
@Builder
@Data
public class RegisteredNode implements Predicate<String> {

    @NonNull
    private final INode node;

    @Singular(value = "child")
    private final Set<RegisteredNode> childNodes;

    @Override
    public boolean test(String s) {
        return this.node.getLiteral().equals(s) || this.node.getAliases().contains(s);
    }
}