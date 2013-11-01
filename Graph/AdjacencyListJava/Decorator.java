interface Decorator
{
	public boolean hasAttribute( Object key );
	public Object getAttribute( Object key );
	public void setAttribute( Object key );
	public void setAttribute( Object key, Object value );
	public void removeAttribute( Object key );
}

