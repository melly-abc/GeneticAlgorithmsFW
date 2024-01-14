package jp.ga.fw.common.util;

import java.lang.reflect.InvocationTargetException;

/**
 * クラスパスクラス
 * クラスパス文字列からインスタンスを生成する機能を提供する。
 * 
 * @author nori
 *
 * @param <T>　インスタンスの型
 */
public class ClassPath<T> {
	
	/**
	 * インスタンス生成メソッド
	 * クラスパス文字列からインスタンスを生成する。
	 * 
	 * @param classPathStr　クラスパス文字列
	 * @return インスタンス
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public T createInstance(String classPathStr) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<?> initClass = Class.forName(classPathStr);
		return (T) initClass.getConstructor().newInstance();
	}
}
