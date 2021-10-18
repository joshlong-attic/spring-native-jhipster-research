package hints;

import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.type.AccessDescriptor;
import org.springframework.nativex.type.HintDeclaration;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.type.TypeSystem;

import java.util.ArrayList;
import java.util.List;


public class MyCustomHints implements NativeConfiguration {

	@Override
	public List<HintDeclaration> computeHints(TypeSystem typeSystem) {
		var className = "com.example.demo.DemoApplication";
		var type = typeSystem.resolveDotted(className);
		var methods = type.getMethods();
		for (var method : methods) {

			System.out.println("------");
			var signatureTypes = method.getSignatureTypes(true);
			for (var t : signatureTypes)
				System.out.println("the type is " + t);



		/*	if (method.getReturnType() == null) {
				System.out.println("theres' no return type for method " + method.getName());
				continue;
			}
			var signatures = method.getReturnType().getTypesInSignature();
			if (signatures == null) {
				System.out.println("the signatures for the method " + method.getName() + " don't exist!");
				continue;
			}

			method.getReturnType()

			for (var typeInSignature : signatures) {
				System.out.println("the type " + typeInSignature +
					" was found in method " +
					method.getName());
			}*/
		}


		var hds = new ArrayList<HintDeclaration>();
		var hd = new HintDeclaration();
		hd.addDependantType(className, new AccessDescriptor(AccessBits.ALL));
		hds.add(hd);
		return hds;
	}

	@Override
	public boolean isValid(TypeSystem typeSystem) {
		return true;
	}
}
