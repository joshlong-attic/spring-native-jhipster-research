package springfox;

import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.type.AccessDescriptor;
import org.springframework.nativex.type.HintDeclaration;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.type.TypeSystem;
import org.springframework.plugin.core.Plugin;

import java.util.ArrayList;
import java.util.List;

public class SpringfoxHints implements NativeConfiguration {

	@Override
	public List<HintDeclaration> computeHints(TypeSystem typeSystem) {

		var list = new ArrayList<HintDeclaration>();
		var pluginClass = typeSystem.resolve(Plugin.class);
		var subtypes = pluginClass.getSubtypes();
		var subtypesHint = new HintDeclaration();
		for (var type : subtypes)	{
			System.out.println("type: " + type.getName());
			subtypesHint.addDependantType(type.getName(), new AccessDescriptor(AccessBits.ALL));
		}
		return list;
	}

	@Override
	public boolean isValid(TypeSystem typeSystem) {
		return typeSystem.resolve(Plugin.class) != null;
	}
}
