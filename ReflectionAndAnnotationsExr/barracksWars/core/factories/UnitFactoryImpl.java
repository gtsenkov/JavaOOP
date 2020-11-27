package ReflectionAndAnnotationsExr.barracksWars.core.factories;

import ReflectionAndAnnotationsExr.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationsExr.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3
		Unit unit = null;

		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);

			unit = (Unit) clazz.getDeclaredConstructor().newInstance();

		} catch (ClassNotFoundException | NoSuchMethodException e) {
			throw new IllegalStateException(e);
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return unit;
	}
}
