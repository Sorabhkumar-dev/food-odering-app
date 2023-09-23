package com.sorabh.grabfood.domain.repository;

import com.sorabh.grabfood.domain.database.LocalDAO;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocalDBRepository_Factory implements Factory<LocalDBRepository> {
  private final Provider<LocalDAO> localDAOProvider;

  public LocalDBRepository_Factory(Provider<LocalDAO> localDAOProvider) {
    this.localDAOProvider = localDAOProvider;
  }

  @Override
  public LocalDBRepository get() {
    return newInstance(localDAOProvider.get());
  }

  public static LocalDBRepository_Factory create(Provider<LocalDAO> localDAOProvider) {
    return new LocalDBRepository_Factory(localDAOProvider);
  }

  public static LocalDBRepository newInstance(LocalDAO localDAO) {
    return new LocalDBRepository(localDAO);
  }
}
