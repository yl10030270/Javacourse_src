import java.util.Map;
import java.util.HashMap;

class AdjacencyListEdge implements Edge
{
	private final Vertex v_;
	private final Vertex w_;

	public AdjacencyListEdge( Vertex v, Vertex w )
	{
		v_ = v;
		w_ = w;
	}
	
	final public Vertex getSource()
	{
		return v_;
	}
	
	final public Vertex getDestination()
	{
		return w_;
	}

	final public Vertex otherVertex( Vertex x )
	{
		if( v_ == x )
			return w_;
		if( w_ == x )
			return v_;
		return null;
	}
	
	final public boolean hasVertex( Vertex x )
	{
		return v_ == x || w_ == x;
	}

	//decorator pattern attributes and methods
	private final Map attributes_ = new HashMap();
	
	public boolean hasAttribute( Object key )
	{
		return attributes_.containsKey( key );
	}
	
	public Object getAttribute( Object key )
	{
		return attributes_.get( key );
	}
	
	public void setAttribute( Object key )
	{
		attributes_.put( key, null );
	}
	
	public void setAttribute( Object key, Object value )
	{
		attributes_.put( key, value );
	}

	public void removeAttribute( Object key )
	{
		attributes_.remove( key );
	}
}

