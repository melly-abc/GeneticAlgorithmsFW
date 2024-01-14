package jp.ga.fw.common.util;

import java.lang.reflect.InvocationTargetException;

/**
 * �N���X�p�X�N���X
 * �N���X�p�X�����񂩂�C���X�^���X�𐶐�����@�\��񋟂���B
 * 
 * @author nori
 *
 * @param <T>�@�C���X�^���X�̌^
 */
public class ClassPath<T> {
	
	/**
	 * �C���X�^���X�������\�b�h
	 * �N���X�p�X�����񂩂�C���X�^���X�𐶐�����B
	 * 
	 * @param classPathStr�@�N���X�p�X������
	 * @return �C���X�^���X
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
