package springfox;

import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.type.*;
import org.springframework.plugin.core.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringfoxHints implements NativeConfiguration {


	private boolean findPluginInHierarchy(
		TypeSystem ts,
		Type type) {

		var currentType = type;
		while (!currentType.equals(pluginType) && !currentType.equals(objType)) {
			currentType = currentType.getSuperclass();
		}

		var result = currentType.equals(pluginType);
		if (result) {
			System.out.println("the current type is " + currentType.getName());
		}
		return result ;
	}

	private boolean isPlugin(
		TypeSystem ts,
		Type type) {
		try {
			var potentialHierarchies = new ArrayList<Type>();
			potentialHierarchies.add(type);
			potentialHierarchies.addAll(Arrays.asList(type.getInterfaces()));
			var isPlugin = potentialHierarchies.stream().anyMatch(t -> findPluginInHierarchy(ts, t));
			if (isPlugin) System.out.println(type.getName() + " is a plugin!");
			return isPlugin;

		}
		catch (Throwable t) {
			return false;
		}
	}

	private Type objType, pluginType;

	@Override
	public List<HintDeclaration> computeHints(TypeSystem typeSystem) {
		objType = typeSystem.resolve(Object.class);
		pluginType = typeSystem.resolve(Plugin.class);
		var results = typeSystem
			.scanUserCodeDirectoriesAndSpringJars(type -> isPlugin(typeSystem, type));
		var subtypesHint = new HintDeclaration();
		results.forEach(type -> {
				subtypesHint.addDependantType(type.getDottedName(), new AccessDescriptor(AccessBits.ALL));
				System.out.println("adding " + type.getName() + ". there are now " + subtypesHint.getDependantTypes().size() + " hints");
			}
		);
		return List.of(subtypesHint);
	}

	@Override
	public boolean isValid(TypeSystem typeSystem) {
		var valid = typeSystem.resolve(Plugin.class) != null;
		System.out.println("is valid? " + valid);
		return valid;
	}
}
