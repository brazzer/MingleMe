// Code generated by dagger-compiler.  Do not edit.
package com.benbo.mingleme;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

/**
 * A {@code Binding<SearchableActivity>} implementation which satisfies
 * Dagger's infrastructure requirements including:
 * 
 * Owning the dependency links between {@code SearchableActivity} and its
 * dependencies.
 * 
 * Being a {@code Provider<SearchableActivity>} and handling creation and
 * preparation of object instances.
 * 
 * Being a {@code MembersInjector<SearchableActivity>} and handling injection
 * of annotated fields.
 */
public final class SearchableActivity$$InjectAdapter extends Binding<SearchableActivity>
    implements Provider<SearchableActivity>, MembersInjector<SearchableActivity> {
  private Binding<android.location.LocationManager> _locationManager;

  public SearchableActivity$$InjectAdapter() {
    super("com.benbo.mingleme.SearchableActivity", "members/com.benbo.mingleme.SearchableActivity", NOT_SINGLETON, SearchableActivity.class);
  }

  /**
   * Used internally to link bindings/providers together at run time
   * according to their dependency graph.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void attach(Linker linker) {
    _locationManager = (Binding<android.location.LocationManager>) linker.requestBinding("android.location.LocationManager", SearchableActivity.class, getClass().getClassLoader());
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getDependencies(Set<Binding<?>> getBindings, Set<Binding<?>> injectMembersBindings) {
    injectMembersBindings.add(_locationManager);
  }

  /**
   * Returns the fully provisioned instance satisfying the contract for
   * {@code Provider<SearchableActivity>}.
   */
  @Override
  public SearchableActivity get() {
    SearchableActivity result = new SearchableActivity();
    injectMembers(result);
    return result;
  }

  /**
   * Injects any {@code @Inject} annotated fields in the given instance,
   * satisfying the contract for {@code Provider<SearchableActivity>}.
   */
  @Override
  public void injectMembers(SearchableActivity object) {
    object._locationManager = _locationManager.get();
  }

}
