package de.christianbernstein.acernis.command.node;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Retrieve the nodes at runtime, with reflections. This source is based around the {@link org.reflections.Reflections} library.
 *
 * @author Christian Bernstein
 */
@Builder
public class ReflectionNodeSource implements INodeSource {

    /**
     * Stores the packages, which will be utilized for searching nodes.
     * If empty, {@link org.reflections.Reflections} will look through each package
     */
    @Singular
    private final List<String> packages;

    private final Class<? extends INode> targetNodeClass;

    @Override
    public List<INode> get() {
        final List<URL> urls = new ArrayList<>();
        this.packages.forEach(pack -> urls.addAll(ClasspathHelper.forPackage(pack)));
        final Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(urls).setScanners(new SubTypesScanner(false)));
        final Set<Class<?>> types = reflections.getSubTypesOf(Object.class);
        final List<INode> nodes = new ArrayList<>();
        System.out.println("nodes: " + nodes.toString());
        for (final Class<?> aClass : types) {
            final List<Field> fields = Arrays.asList(aClass.getDeclaredFields().clone());
            fields.forEach(field -> {
                final INode node = this.validateAndConstructNode(field);
                if (node != null){
                    nodes.add(node);
                }
            });

        }
        return nodes;
    }

    private INode validateAndConstructNode(@NonNull final Field field){
        if (!field.getType().equals(this.targetNodeClass)){
            return null;
        }
        if (!field.isAnnotationPresent(NodeDeclaration.class)){
            return null;
        }
        return null;
    }
}
