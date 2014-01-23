// Code generated by dagger-compiler.  Do not edit.
package com.benbo.mingleme;

import dagger.internal.Binding;
import dagger.internal.ModuleAdapter;
import java.util.Map;
import javax.inject.Provider;

/**
 * A manager of modules and provides adapters allowing for proper linking and
 * instance provision of types served by {@code @Provides} methods.
 */
public final class ModuleMock$$ModuleAdapter extends ModuleAdapter<ModuleMock> {
  private static final String[] INJECTS = { "members/com.benbo.mingleme.MainActivity", };
  private static final Class<?>[] STATIC_INJECTIONS = { };
  private static final Class<?>[] INCLUDES = { };

  public ModuleMock$$ModuleAdapter() {
    super(com.benbo.mingleme.ModuleMock.class, INJECTS, STATIC_INJECTIONS, false /*overrides*/, INCLUDES, false /*complete*/, false /*library*/);
  }

  @Override
  public ModuleMock newModule() {
    return new com.benbo.mingleme.ModuleMock();
  }

  /**
   * Used internally obtain dependency information, such as for cyclical
   * graph detection.
   */
  @Override
  public void getBindings(Map<String, Binding<?>> map, ModuleMock module) {
    map.put("com.benbo.mingleme.data.repo.IUserRepository", new ProvideUserRepositoryProvidesAdapter(module));
  }

  /**
   * A {@code Binding<com.benbo.mingleme.data.repo.IUserRepository>} implementation which satisfies
   * Dagger's infrastructure requirements including:
   * 
   * Being a {@code Provider<com.benbo.mingleme.data.repo.IUserRepository>} and handling creation and
   * preparation of object instances.
   */
  public static final class ProvideUserRepositoryProvidesAdapter extends Binding<com.benbo.mingleme.data.repo.IUserRepository>
      implements Provider<com.benbo.mingleme.data.repo.IUserRepository> {
    private final ModuleMock module;

    public ProvideUserRepositoryProvidesAdapter(ModuleMock module) {
      super("com.benbo.mingleme.data.repo.IUserRepository", null, NOT_SINGLETON, "com.benbo.mingleme.ModuleMock.provideUserRepository()");
      this.module = module;
      setLibrary(false);
    }

    /**
     * Returns the fully provisioned instance satisfying the contract for
     * {@code Provider<com.benbo.mingleme.data.repo.IUserRepository>}.
     */
    @Override
    public com.benbo.mingleme.data.repo.IUserRepository get() {
      return module.provideUserRepository();
    }
  }
}
